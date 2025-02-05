package com.artur.common.entity.user;


import com.artur.common.entity.Like;
import com.artur.common.entity.SearchHistory;
import com.artur.common.entity.VideoEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.*;


@Getter
@Setter
@Entity
public class UserEntity {

    @Id
    private String id;
    @NotBlank
    private String username;
    @NotBlank
    private String authorities;
    @NotBlank
    private String email;
    private String picture;



    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<VideoEntity> userVideos = new ArrayList<>();
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "historyOwner")
    private  List<SearchHistory> searchHistory = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userEntity")
    private Set<Like> likes = new HashSet<>();
    @ManyToMany
    @JoinTable(
            name = "user_subscribes",
            joinColumns = @JoinColumn(name = "subscribes_id"),
            inverseJoinColumns = @JoinColumn(name = "subscribers_id")
    )
    private Set<UserEntity> subscribes = new HashSet<>();
    @ManyToMany(mappedBy = "subscribes")
    private  Set<UserEntity> subscribers = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userEntity")
    private List<WatchHistory> watchHistory = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userEntity")
    @PrimaryKeyJoinColumn
    private UserMetadata userMetadata;

    public UserEntity(String id, String username, String email, String picture, String authorities) {
        this();
        this.id = id;
        this.username = username;
        this.email = email;
        this.picture = picture;
        this.authorities = authorities;
    }

    public UserEntity() {
        this.userMetadata = new UserMetadata(this);
    }

    @PostLoad
    public void sortWatchHistory(){
        this.watchHistory.sort(Comparator.comparing(WatchHistory::getDate).reversed());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
