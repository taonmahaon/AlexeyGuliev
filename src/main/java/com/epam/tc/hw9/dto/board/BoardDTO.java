package com.epam.tc.hw9.dto.board;

import com.epam.tc.hw9.dto.minors.LabelNames;
import com.epam.tc.hw9.dto.minors.Limits;
import com.epam.tc.hw9.dto.minors.Prefs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class BoardDTO {
    public String id;
    public String name;
    public String desc;
    public Object descData;
    public boolean closed;
    public String idOrganization;
    public Object idEnterprise;
    public boolean pinned;
    public String url;
    public String shortUrl;
    public Prefs prefs;
    public LabelNames labelNames;
    public Limits limits;
}


