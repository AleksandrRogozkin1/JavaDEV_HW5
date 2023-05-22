package org.example.select;

public class OldestYoungestWorkers {
    private String type;
    private String name;
    private String birtday;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirtday() {
        return birtday;
    }

    public void setBirtday(String birtday) {
        this.birtday = birtday;
    }

    @Override
    public String toString() {
        return "OldestYoungestWorkers{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", birtday='" + birtday + '\'' +
                '}';
    }
}
