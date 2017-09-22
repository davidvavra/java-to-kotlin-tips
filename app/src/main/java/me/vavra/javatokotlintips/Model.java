package me.vavra.javatokotlintips;

import java.util.List;

class Model {
    private String name;
    private List<String> titles;
    private String twitter;
    private String medium;

    public Model(String name, List<String> titles, String twitter, String medium) {
        this.name = name;
        this.titles = titles;
        this.twitter = twitter;
        this.medium = medium;
    }

    public String getName() {
        return name;
    }

    public List<String> getTitles() {
        return titles;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getMedium() {
        return medium;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model model = (Model) o;

        if (name != null ? !name.equals(model.name) : model.name != null) return false;
        if (titles != null ? !titles.equals(model.titles) : model.titles != null) return false;
        if (twitter != null ? !twitter.equals(model.twitter) : model.twitter != null) return false;
        return medium != null ? medium.equals(model.medium) : model.medium == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (titles != null ? titles.hashCode() : 0);
        result = 31 * result + (twitter != null ? twitter.hashCode() : 0);
        result = 31 * result + (medium != null ? medium.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                ", titles=" + titles +
                ", twitter='" + twitter + '\'' +
                ", medium='" + medium + '\'' +
                '}';
    }
}
