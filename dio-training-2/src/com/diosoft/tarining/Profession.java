package com.diosoft.tarining;


public enum Profession {
     ENGINEER(2, "Engineer programmer"), WORKER(1, " builder"), STUDENT(0, "lazy man");

    private final int status;
    private final String description;

    private Profession(int status, String description) {
        this.status = status;
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Profession{");
        sb.append("status=").append(status);
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
