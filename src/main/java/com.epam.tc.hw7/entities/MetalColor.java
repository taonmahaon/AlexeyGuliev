package com.epam.tc.hw7.entities;

import com.epam.jdi.tools.DataClass;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
public class MetalColor extends DataClass<MetalColor> {
    private List<Integer> summary;
    public List<String> elements;
    public String color;
    public String metals;
    public List<String> vegetables;

    @Override
    public String toString() {
        return new StringBuilder().append("Summary: ").append(summary.stream().reduce(0, Integer::sum))
                                  .append(", Elements: ").append(StringUtils.join(elements, ", "))
                                  .append(", Color: ").append(color).append(", Metal: ").append(metals)
                                  .append(", Vegetables: ").append(StringUtils.join(vegetables, ", "))
                                  .toString();
    }
}
