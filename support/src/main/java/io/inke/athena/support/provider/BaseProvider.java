package io.inke.athena.support.provider;

public interface BaseProvider<T> {

    /**
     * generate insert sql
     *
     * @param model model info
     * @return insert sql
     */
    String addModel(T model);

}
