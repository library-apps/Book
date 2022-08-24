package com.books.books.model;

import com.books.books.model.audit.AuditModel;
import lombok.*;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity(name = "User")
@Table(name = "users")
// @Setter
GrantedAuthority()
// @AllArgsConstructor
// @NoArgsConstructor
// @ToString
public class User extends AuditModel<String> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = false, unique = true)
    private Long id;

    @Column(name = "username", nullable = false, length = 255)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone", nullable = true)
    private String phone;

    @Column(name = "isDeleted", nullable = false, columnDefinition = "integer default 0")
    private Integer isDeleted;

    @Column(name = "deletedAt", nullable = true)
    private Date deletedAt;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<Role>();

    
}
