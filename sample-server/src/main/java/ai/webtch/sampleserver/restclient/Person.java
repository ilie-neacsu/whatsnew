package ai.webtch.sampleserver.restclient;

public class Person {

    private String salutation;
    private String name;

    public Person() { }

    public Person(String salutation, String name) {
        this.salutation = salutation;
        this.name = name;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
