package Membership.src.view.member;

import java.awt.event.*;
import java.lang.reflect.Member;
import java.util.UUID;

import Membership.src.model.JenisMember;
import model.*;
import dao.MemberDao;

public class MemberButtonSimpanActionListener implements ActionListener{
    private MemberFrame memberFrame;
    private MemberDao memberDao;

    public MemberButtonSimpanActionListener(MemberFrame memberFrame, MemberDao memberDao)
    {
        this.memberFrame = memberFrame;
        this.memberDao = memberDao;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String nama = this.memberFrame.getNama();
        if (nama.isEmpty())
        {
            this.memberFrame.showAlert("Nama tidak boleh kosong");
        } else
        {
            JenisMember jenisMember = this.memberFrame.getJenisMember();
            Member member = new Member();
            member.setId(UUID.randomUUID().toString())
            member.setNama(nama);
            member.setJenisMember(jenisMember);

            this.memberFrame.addMember(member);
            this.memberDao.insert(member);
        }
    }
    
}
