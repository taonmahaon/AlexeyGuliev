package com.epam.tc.hw9.dto.minors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
public class Prefs {
    public String permissionLevel;
    public boolean hideVotes;
    public String voting;
    public String comments;
    public String invitations;
    public boolean selfJoin;
    public boolean cardCovers;
    public boolean isTemplate;
    public String cardAging;
    public boolean calendarFeedEnabled;
    public String background;
    public Object backgroundImage;
    public Object backgroundImageScaled;
    public boolean backgroundTile;
    public String backgroundBrightness;
    public String backgroundColor;
    public String backgroundBottomColor;
    public String backgroundTopColor;
    public boolean canBePublic;
    public boolean canBeEnterprise;
    public boolean canBeOrg;
    public boolean canBePrivate;
    public boolean canInvite;
}
