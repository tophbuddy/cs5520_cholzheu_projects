package edu.neu.khoury.madsea.chrisholzheu;

import androidx.room.TypeConverter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ToDoItemContentConverter {

    @TypeConverter
    public static String convertSet(Set<String> tags) {
        return tags.toString();
    }

    @TypeConverter
    public static Set<String> convertString(String tags) {
        return Arrays.stream(tags.substring(1,tags.length()-1).split("\\s*,\\s*")).collect(Collectors.toSet());
    }

    @TypeConverter
    public static LocalDateTime convertTimeStamp(Long value) {
        return value == null ? null : LocalDateTime.ofInstant(Instant.ofEpochSecond(value), ZoneOffset.UTC);
    }

    @TypeConverter
    public static Long convertDate(LocalDateTime localDateTime) {
        return localDateTime == null ? null : localDateTime.toEpochSecond(ZoneOffset.UTC);
    }
}
