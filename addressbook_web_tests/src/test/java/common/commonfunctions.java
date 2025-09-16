package common;

import java.io.File;
import java.nio.file.Paths;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class commonfunctions {
    public static String randomString(int n){
        var rnd = new Random();
        Supplier<Integer> randomNumber =  () -> rnd.nextInt(26);
        var result = Stream.generate(randomNumber)
                .limit(n)
                .map(i-> 'a' + i)
                .map(Character::toString)
                .collect(Collectors.joining());

        return result;
    }

    public static String randomfile(String dir){
       var filenames = new File(dir).list();
       var rnd = new Random();
       var index = rnd.nextInt(filenames.length);
       return Paths.get(dir,filenames[index]).toString();
    }
}
