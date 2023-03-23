package com.example.test_nikitina;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Base {
    public static List<Integer> id_group= Arrays.asList(1,1,1,1,1,2,2,2,3,3,3,3);
    public static List<String> name_muscle= Arrays.asList("Shoulders","Traps", "Quads", "Hamstrings", "Calves", "Chest",
            "Triceps", "Obliques", "Biceps", "Traps (mid-back)", "Lower back","Lats");
   // public List<Integer> id_group= Arrays.asList(1,1,1,1,1,2,2,2,3,3,3);

    public static List<Integer> getId_group() {
        return id_group;
    }

    public static List<String> getName_muscle() {
        return name_muscle;
    }
}
