package com.hospitalVM.atencion.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@Table


public class Audit {
    @Column(name="created_at")
    private LocalDateTime createAt;

    @Column(name="update_at")
    private LocalDateTime updateAt;

    @PrePersist
    public void prePersist(){
        this.createAt = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate(){
        this.updateAt = LocalDateTime.now();
    }


}
