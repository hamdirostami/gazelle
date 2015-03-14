package com.pooyaco.gazelle.dto;

/**
 * Created with IntelliJ IDEA.
 * User: h.rostami
 * Date: 28/01/15
 * Time: 02:50 م
 * To change this template use File | Settings | File Templates.
 */
public class PagingDto extends Dto{

      private int offset;
      private int max;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
