package org.nioun.essentials.mog.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.nioun.essentials.mog.model.Client;

import lombok.AllArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderResponse {

    private String nom;
    private String style;
}
