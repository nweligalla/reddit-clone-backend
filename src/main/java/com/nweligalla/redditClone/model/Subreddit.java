package com.nweligalla.redditClone.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.time.Instant;
import java.util.List;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subreddit {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank(message = "Community name is required")
    private String name;
    @NotBlank(message = "Discription is required")
    private String description;

    @OneToMany(fetch = LAZY)
    private List<Post> posts;

    private Instant createddate;

    @ManyToOne(fetch = LAZY)
    private User user;

}
