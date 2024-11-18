package org.example.filewriter;

public class DataTransferObject {

    private String name;
    private String type;
    private Structure1 structure1;

    public DataTransferObject(String name, String type, Structure1 structure1) {
        this.name = name;
        this.type = type;
        this.structure1 = structure1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Structure1 getStructure1() {
        return structure1;
    }

    public void setStructure1(Structure1 structure1) {
        this.structure1 = structure1;
    }
}
