package ru.job4j.pojo;

import java.util.Date;

public class License {
    private String owner;
    private String model;
    private String code;
    private Date created;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof License license)) {
            return false;
        }
        if (getOwner() != null ? !getOwner().equals(license.getOwner()) : license.getOwner() != null) {
            return false;
        }
        if (getModel() != null ? !getModel().equals(license.getModel()) : license.getModel() != null) {
            return false;
        }
        if (getCode() != null ? !getCode().equals(license.getCode()) : license.getCode() != null) {
            return false;
        }
        return getCreated() != null ? getCreated().equals(license.getCreated()) : license.getCreated() == null;
    }

    @Override
    public int hashCode() {
        int result = getOwner() != null ? getOwner().hashCode() : 0;
        result = 31 * result + (getModel() != null ? getModel().hashCode() : 0);
        result = 31 * result + (getCode() != null ? getCode().hashCode() : 0);
        result = 31 * result + (getCreated() != null ? getCreated().hashCode() : 0);
        return result;
    }
}