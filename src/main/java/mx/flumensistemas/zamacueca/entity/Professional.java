package mx.flumensistemas.zamacueca.entity;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "professional")
public class Professional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @NonNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Name cannot be blank")
    @NonNull
    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name= "role")
    private String role;

    
    @JsonIgnore
    @OneToMany(mappedBy = "professional", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    


    public Professional(String name, String lastname, String role) {
        this.name = name;
        this.lastname = lastname;
        this.role = role;
    }

    
}
