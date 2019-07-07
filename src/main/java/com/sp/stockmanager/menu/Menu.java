package com.sp.stockmanager.menu;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sp.stockmanager.meal.Meal;
import com.sp.stockmanager.record.Record;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "day_time", nullable = false)
    private String dayTime;

    @Column(name = "week_day", nullable = false)
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate weekDay;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "menu_meal",
            joinColumns = @JoinColumn(name = "menu_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id", referencedColumnName = "id"))
    private Set<Meal> meals = new HashSet<>();

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<Record> records = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDayTime() {
        return dayTime;
    }

    public void setDayTime(String dayTime) {
        this.dayTime = dayTime;
    }

    public LocalDate getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(LocalDate weekDay) {
        this.weekDay = weekDay;
    }

    public Set<Meal> getMeals() {
        return meals;
    }

    public void setMeals(Set<Meal> meals) {
        this.meals = meals;
    }
}
