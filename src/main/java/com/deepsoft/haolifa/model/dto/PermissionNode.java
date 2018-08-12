package com.deepsoft.haolifa.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public class PermissionNode {

    @NonNull
    private String url;
    @NonNull
    private String description;

    private List<PermissionNode> child = new ArrayList<>();

}
