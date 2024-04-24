package dk.kea.dat3js.hogwarts5.shared;

public interface PersonWithNames {

    String getFirstName();

    String getMiddleName();

    String getLastName();

    void setFirstName(String firstName);

    void setMiddleName(String middleName);

    void setLastName(String lastName);

    default void setFullName(String fullName) {
        if (fullName == null || fullName.isEmpty()) {
            setFirstName(null);
            setMiddleName(null);
            setLastName(null);
            return;
        }

        fullName = fullName.trim();
        int firstSpace = fullName.indexOf(' ');
        int lastSpace = fullName.lastIndexOf(' ');

        if (firstSpace == -1) {
            setFirstName(fullName);
            setMiddleName(null);
            setLastName(null);
        } else if (firstSpace == lastSpace) {
            setFirstName(fullName.substring(0, firstSpace));
            setMiddleName(null);
            setLastName(fullName.substring(firstSpace + 1));
        } else {
            setFirstName(fullName.substring(0, firstSpace));
            setMiddleName(fullName.substring(firstSpace + 1, lastSpace));
            setLastName(fullName.substring(lastSpace + 1));
        }
    }

    default String getFullName() {
        return getFirstName() + " " + (getMiddleName() != null ? getMiddleName() + " " : "") + getLastName();
    }

    default String capitalize(String name) {
        if (name != null && !name.isEmpty()) {
            if (name.toLowerCase().startsWith("mc")) {
                return "Mc" + Character.toUpperCase(name.charAt(2)) + name.substring(3);
            } else {
                return Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();
            }
        }
        return name;
    }

}
