package com.wind.windrecruitmentapi.utils.authorization;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.wind.windrecruitmentapi.utils.authorization.Permission.*;


@RequiredArgsConstructor
@Getter
public enum UserRole {

    CANDIDATE(
            Set.of(
                CANDIDATE_CREATE, CANDIDATE_READ, CANDIDATE_UPDATE, CANDIDATE_DELETE
            )
    ),

    MANAGER(
            Set.of(
                MANAGER_CREATE, MANAGER_READ, MANAGER_DELETE, MANAGER_UPDATE
            )
    ),

    RECRUITER(
            Set.of(
                RECRUITER_CREATE, RECRUITER_READ, RECRUITER_UPDATE, RECRUITER_DELETE
    )
    )
    ;

    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }

}
