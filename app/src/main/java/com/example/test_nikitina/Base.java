package com.example.test_nikitina;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Base {
    public static List<Integer> id_group= Arrays.asList(1,1,1,1,1,2,2,2,3,3,3,3);
    public static List<String> name_muscle= Arrays.asList("Shoulders","Traps", "Quads", "Hamstrings", "Calves", "Chest",
            "Triceps", "Obliques", "Biceps", "Traps (mid-back)", "Lower back","Lats");
    public static List<Integer> id_musle= Arrays.asList(1,1,1);
    public static List<String> name_exer= Arrays.asList("Barbell Overhead Press","Dumbbell Seated Overhead \nPress",
            "Cable Lateral Raise");

    public static List<String> photo= Arrays.asList("https://149874912.v2.pressablecdn.com/wp-content/uploads/2020/12/Overhead-press-exercise.gif",
            "https://thumbs.gfycat.com/ExcitableOblongFluke-max-1mb.gif",
            "https://fitnessprogramer.com/wp-content/uploads/2021/02/Cable-Lateral-Raise.gif");

    public static List<Integer> descr= Arrays.asList(R.string.Barbell_Overhead_Press, R.string.Dumbbell_Seated_Overhead_Press, R.string.Cable_Lateral_Raise);

    public static List<Integer> getId_group() {
        return id_group;
    }

    public static List<Integer> getId_musle() {
        return id_musle;
    }

    public static List<String> getName_exer() {
        return name_exer;
    }

    public static List<String> getPhoto() {
        return photo;
    }

    public static List<Integer> getDescr() {
        return descr;
    }

    public static List<String> getName_muscle() {
        return name_muscle;
    }
}
