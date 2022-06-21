package com.unilever.utilityservice.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data

@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class DefaultLabelValue implements Serializable, Comparable<DefaultLabelValue> {

    private static final long serialVersionUID = 1L;

    protected String label;
    protected Long value;

    public DefaultLabelValue(String label, Long value) {
        this.label = label;
        this.value = value;
    }

    public DefaultLabelValue(Long value, String label) {
        this.label = label;
        this.value = value;
    }

    @Override
    public int compareTo(DefaultLabelValue o) {
        return this.getValue().compareTo(o.getValue());
    }
}
