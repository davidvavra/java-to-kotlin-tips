package me.vavra.javatokotlintips;

import java.util.List;

class Model {
    private String name;
    private List<String> titles;

    public Model(String name, List<String> titles) {
        this.name = name;
        this.titles = titles;
    }

    public String getName() {
        return name;
    }

    public List<String> getTitles() {
        return titles;
    }

    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                ", titles=" + titles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model model = (Model) o;

        if (name != null ? !name.equals(model.name) : model.name != null) return false;
        return titles != null ? titles.equals(model.titles) : model.titles == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (titles != null ? titles.hashCode() : 0);
        return result;
    }
}
