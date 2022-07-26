// ##DELETE_FILE:
package com.ssafy.live5.parse;

/**
 * @since 2021. 7. 9.
 */
public class Student {
    private String no;
    private String name;
    private String loc;
    private String phone;
    // getter / setter / default constructor / toString / parameter constructor ..
    
    public String getNo() {
        return no;
    }
    public void setNo(String no) {
        this.no = no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLoc() {
        return loc;
    }
    public void setLoc(String loc) {
        this.loc = loc;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "[no=" + no + ", name=" + name + ", loc=" + loc + ", phone=" + phone + "]";
    }
    
    
}
