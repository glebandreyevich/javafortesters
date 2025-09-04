package generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import common.commonfunctions;
import model.GroupData;
import java.io.File;

import java.io.IOException;
import java.util.ArrayList;

public class Generator {
    @Parameter(names={"--type", "-l"})
    String type;
    @Parameter(names={"--output", "-o"})
    String output;
    @Parameter(names={"--count", "-n"})
    int count;
    @Parameter(names={"--format", "-f"})
    String format;
    public static void main(String[] args) throws IOException {
        var generator = new Generator();
        JCommander.newBuilder()
                .addObject(generator)
                .build()
                .parse(args);
        generator.run();
    }

    private void run() throws IOException {
        var data = generate();
        save(data);

    }

    private void save(Object data) throws IOException {
        if("json".equals(format)) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File(output), data);
        } else {
            throw new IllegalArgumentException("Unknown Type" + format);
        }
    }

    private Object generate() {
        if ("groups".equals(type)){
            return generateGroups();
        }
        if ("contacts".equals(type)){
            return generateContact();
        } else {
            throw new IllegalArgumentException("Unknown Type" + type);
        }
    }

    private Object generateGroups() {
        var result = new ArrayList<GroupData>();
        for (int i = 1; i < count; i++) {
            result.add(new GroupData().withName(commonfunctions.randomString(i * 10))
                    .withHeader(commonfunctions.randomString(i * 10))
                    .withFooter(commonfunctions.randomString(i * 10)));
        }
        return result;
    }

    private Object generateContact() {
        return null;
    }

}
