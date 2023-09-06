// package com.example.above.security;

// import java.util.ArrayList;
// import java.util.Collection;
// import java.util.List;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.ToString;

// @AllArgsConstructor
// @NoArgsConstructor
// @Getter
// @Builder
// @ToString
// public class UserDetail implements UserDetails, OAuth2User {

//     private String role;      // 권한 (USER, ADMIN, BLACKLIST, PLANNER)

//     // 권한부여
//     @Override
//     public Collection<? extends GrantedAuthority> getAuthorities() {
//         List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//         authorities.add(new SimpleGrantedAuthority(role));
//         return authorities;
//     }
//  }