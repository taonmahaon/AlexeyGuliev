package com.epam.tc.hw9.dto.list;

import com.epam.tc.hw9.dto.minors.Limits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ListDTO {
    public String id;
    public String name;
    public boolean closed;
    public int pos;
    public String idBoard;
    public Limits limits;
}
