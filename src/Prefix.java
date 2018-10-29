public enum Prefix {
    RO("Romania", "+40"), DE("Germania","+49"), IT("Italy", "+39"), GR("Greece", "+30");
    private String country;
    private String prefix;

    Prefix(String country, String prefix) {
        this.country = country;
        this.prefix = prefix;
    }

    public String getCountry() {
        return country;
    }

    public String getPrefix() {
        return prefix;
    }

}
