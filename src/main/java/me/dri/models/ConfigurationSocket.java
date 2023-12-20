package me.dri.models;

import java.util.Objects;

public class ConfigurationSocket
{

    private String host;
    private Integer port;
    private String password;

    public ConfigurationSocket() {

    }

    public ConfigurationSocket(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    public ConfigurationSocket(String host, Integer port, String password) {
        this.host = host;
        this.port = port;
        this.password = password;
    }


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfigurationSocket that = (ConfigurationSocket) o;
        return Objects.equals(host, that.host) && Objects.equals(port, that.port) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(host, port, password);
    }

    @Override
    public String toString() {
        return "ConfigurationSocket{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", password='" + password + '\'' +
                '}';
    }
}
