package com.brazgouka.arbitrager.repository;

import com.brazgouka.arbitrager.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, String> {}
