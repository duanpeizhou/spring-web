package com.bluelemontree.depth.param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author duanpeizhou on 2018/7/3 下午2:20.
 */
public class SaveHello {

    private String name;
    private String address;
    private Date birthDay;
    private LocalDateTime localDateTime = LocalDateTime.now();
    private LocalDate localDate = LocalDate.now();
    private List<String> contact;
    private Optional<String> bigData;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public List<String> getContact() {
        return contact;
    }

    public void setContact(List<String> contact) {
        this.contact = contact;
    }

    public Optional<String> getBigData() {
        return bigData;
    }

    public void setBigData(Optional<String> bigData) {
        this.bigData = bigData;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SaveHello{");
        sb.append("name='").append(name).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", birthDay=").append(birthDay);
        sb.append(", localDateTime=").append(localDateTime);
        sb.append(", localDate=").append(localDate);
        sb.append(", contact=").append(contact);
        sb.append('}');
        return sb.toString();
    }
}
