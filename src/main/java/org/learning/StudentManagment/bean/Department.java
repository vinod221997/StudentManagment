package org.learning.StudentManagment.bean;

public class Department {
    private Long departmentId;
    private String name;
    private String code;
    private String headOfDepartment;

    public Department() {
    }

    public Department(Long departmentId, String name, String code, String headOfDepartment) {
        this.departmentId = departmentId;
        this.name = name;
        this.code = code;
        this.headOfDepartment = headOfDepartment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(String headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", headOfDepartment='" + headOfDepartment + '\'' +
                '}';
    }
}
