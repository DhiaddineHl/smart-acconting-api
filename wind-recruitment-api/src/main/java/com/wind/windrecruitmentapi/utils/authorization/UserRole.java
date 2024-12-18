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

    BUSINESS(
            Set.of(
                BUSINESS_CREATE, BUSINESS_READ, BUSINESS_UPDATE, BUSINESS_DELETE
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
