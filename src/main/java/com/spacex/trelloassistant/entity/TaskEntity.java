package com.spacex.trelloassistant.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "task")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String description;
    @Column
    private String title;
    @OneToOne
    private CategoryEntity categoryEntity;
    @OneToOne
    private TypeTaskEntity typeTaskEntity;
}
