package io.inke.athena.support.mapper;

public interface BaseMapper<T> {

    Integer insertModel(T object);

    /**
     * find model by name
     *
     * @param name source name
     * @return model
     */
    T findByName(CharSequence name);

    /**
     * find model by id
     *
     * @param id source id
     * @return model
     */
    T findById(Long id);

}
