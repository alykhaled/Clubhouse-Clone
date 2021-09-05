package com.alykhaled.clubhouseclone;

import java.util.List;

public class ClubItem {
    public int club_id;
    public String name;
    public String description;
    public String photo_url;
    public int num_members;
    public int num_followers;
    public boolean enable_private;
    public boolean is_follow_allowed;
    public boolean is_membership_private;
    public boolean is_community;
    public List<Rule> rules;
    public String url;
    public int num_online;

    public class Rule {
        public String desc;
        public String title;
    }

    public ClubItem(int club_id, String name, String description, String photo_url, int num_members, int num_followers, boolean enable_private, boolean is_follow_allowed, boolean is_membership_private, boolean is_community, List<Rule> rules, String url, int num_online) {
        this.club_id = club_id;
        this.name = name;
        this.description = description;
        this.photo_url = photo_url;
        this.num_members = num_members;
        this.num_followers = num_followers;
        this.enable_private = enable_private;
        this.is_follow_allowed = is_follow_allowed;
        this.is_membership_private = is_membership_private;
        this.is_community = is_community;
        this.rules = rules;
        this.url = url;
        this.num_online = num_online;
    }

    public int getClub_id() {
        return club_id;
    }

    public void setClub_id(int club_id) {
        this.club_id = club_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public int getNum_members() {
        return num_members;
    }

    public void setNum_members(int num_members) {
        this.num_members = num_members;
    }

    public int getNum_followers() {
        return num_followers;
    }

    public void setNum_followers(int num_followers) {
        this.num_followers = num_followers;
    }

    public boolean isEnable_private() {
        return enable_private;
    }

    public void setEnable_private(boolean enable_private) {
        this.enable_private = enable_private;
    }

    public boolean isIs_follow_allowed() {
        return is_follow_allowed;
    }

    public void setIs_follow_allowed(boolean is_follow_allowed) {
        this.is_follow_allowed = is_follow_allowed;
    }

    public boolean isIs_membership_private() {
        return is_membership_private;
    }

    public void setIs_membership_private(boolean is_membership_private) {
        this.is_membership_private = is_membership_private;
    }

    public boolean isIs_community() {
        return is_community;
    }

    public void setIs_community(boolean is_community) {
        this.is_community = is_community;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNum_online() {
        return num_online;
    }

    public void setNum_online(int num_online) {
        this.num_online = num_online;
    }
}
