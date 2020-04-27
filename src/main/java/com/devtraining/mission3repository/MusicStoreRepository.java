    package com.devtraining.mission3repository;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.jdbc.core.BeanPropertyRowMapper;
    import org.springframework.jdbc.core.JdbcTemplate;
    import org.springframework.stereotype.Repository;

    import java.util.List;
    import java.util.Optional;

    @Repository
    public class MusicStoreRepository {
        @Autowired
        JdbcTemplate jdbcTemplate;

        public List< MusicStoreModel > findAll() {
            return jdbcTemplate.query("select * from musiclist", new BeanPropertyRowMapper<MusicStoreModel>(MusicStoreModel.class));
        }

        public Optional < MusicStoreModel > findById(String id) {
            return Optional.of(jdbcTemplate.queryForObject("select * from musiclist where id=?", new Object[]{
                            id
                    },
                    new BeanPropertyRowMapper<MusicStoreModel>(MusicStoreModel.class)));
        }

        public void deleteById(String id) {
            jdbcTemplate.update("delete from musiclist where id=?", new Object[]{
                    id
            });
        }

        public void insert(MusicStoreModel music) {
            jdbcTemplate.update("insert into musiclist (id, song, artist, album) values (?, ?, ?, ?)",
                    new Object[]{
                            music.getId(), music.getSong(), music.getArtist(), music.getAlbum()
                    });
        }

        public void update(MusicStoreModel music) {
            jdbcTemplate.update("update musiclist set song = ?, artist = ?, album = ?"+"where id = ?",
                    new Object[]{
                            music.getSong(), music.getArtist(), music.getAlbum(), music.getId()
                    });
        }
    }