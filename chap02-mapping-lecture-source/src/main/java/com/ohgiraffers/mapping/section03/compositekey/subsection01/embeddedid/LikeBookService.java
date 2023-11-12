package com.ohgiraffers.mapping.section03.compositekey.subsection01.embeddedid;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LikeBookService {

    private LikeRepository likeRepository;

    public LikeBookService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Transactional
    public void generateLikeBook(LikeDTO likeInfo) {

        Like like = new Like(
                new LikeCompositeKey(
                        new LikedMemberNo(likeInfo.getLikedMemberNo()),
                        new LikedBookNo(likeInfo.getLikedBookNo())
                )
        );

        likeRepository.save(like);
    }
}
