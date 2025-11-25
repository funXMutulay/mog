package org.nioun.essentials.mog.dto;

import lombok.Data;
import lombok.*;
import lombok.NoArgsConstructor;

import org.nioun.essentials.mog.model.Client;

import lombok.AllArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderRequest {

private Client client ;

}
