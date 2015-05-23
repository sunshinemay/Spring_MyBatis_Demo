package <#if package!="">${package}.</#if>model;

import java.io.Serializable;

public class ${model} implements Serializable {

    private ${PK} id;
    <#assign keys = properties?keys>
    <#list keys as key>
    private ${properties[key]} ${key};
    </#list>

    public ${model}() {
    }

    public ${PK} getId() {
        return id;
    }

    public void setId(${PK} id) {
        this.id = id;
    }
    <#assign keys = properties?keys>
    <#list keys as key>

    public ${properties[key]}  get${key?cap_first}() {
        return this.${key};
    }

    public void set${key?cap_first}(${properties[key]} ${key}) {
        this.${key} = ${key};
    }
    </#list>
}