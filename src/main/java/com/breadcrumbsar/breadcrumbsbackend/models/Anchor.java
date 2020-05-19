package com.breadcrumbsar.breadcrumbsbackend.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Anchor
{
    @Id
    @NonNull
    private String anchorId;
    @NonNull
    private double lattitude;
    @NonNull
    private double longitude;
}
