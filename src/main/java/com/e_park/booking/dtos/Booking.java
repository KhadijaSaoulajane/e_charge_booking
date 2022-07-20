package com.e_park.booking.dtos;

import javax.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "booking_time")
    private String booking_time;
    @Column(name = "plug_time")
    private String plug_time;
    @Column(name = "unplug_time")
    private String unplug_time;
    @Column(name = "user_id")
    private Long user_id;
    @Column(name = "cs_id")
    private Long cs_id;


    public String getBooking_time() {
        return booking_time;
    }

    public void setBooking_time(String booking_time) {
        this.booking_time = booking_time;
    }

    public String getPlug_time() {
        return plug_time;
    }

    public void setPlug_time(String plug_time) {
        this.plug_time = plug_time;
    }

    public String getUnplug_time() {
        return unplug_time;
    }

    public void setUnplug_time(String unplug_time) {
        this.unplug_time = unplug_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getCs_id() {
        return cs_id;
    }

    public void setCs_id(Long cs_id) {
        this.cs_id = cs_id;
    }
}
