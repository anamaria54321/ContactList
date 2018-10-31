public enum Prefix {
    RO("Romania", "+40"), DE("Germania", "+49"), IT("Italy", "+39"), GR("Greece", "+30");
    private String country;
    private String code;

    Prefix(String country, String prefix) {
        this.country = country;
        this.code = prefix;
    }

    public String getCountry() {
        return country;
    }

    public String getPrefix() {
        return code;
    }

    public static Prefix getPrefixByName(String name) {
        for (Prefix prefix : Prefix.values()) {
            if (prefix.country.equals(name)) {
                return prefix;
            }

        }
        return null;
    }
    public static Prefix getPrefixByCode(String name) {
        for (Prefix prefix : Prefix.values()) {
            if (prefix.code.equals(name)) {
                return prefix;
            }

        }
        return null;
    }
}
