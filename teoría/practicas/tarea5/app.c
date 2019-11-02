#include <stdio.h>
#include <stdlib.h>

/*

*/

int lines = 0;
int manage_()
{
    char c = get_char();
    if (c == 'a')
    {
        return manage_a();
    }
    else if (c == 'b')
    {
        return manage_b();
    }
    else if (c == 'c')
    {
        return manage_c();
    }
    else if (c == 'd')
    {
        return manage_d();
    }
    else if (c == 'e')
    {
        return manage_e();
    }
    else if (c == 'f')
    {
        return manage_f();
    }
    else if (c == 'g')
    {
        return manage_g();
    }
    else if (c == 'i')
    {
        return manage_i();
    }
    else if (c == 'l')
    {
        return manage_l();
    }
    else if (c == 'r')
    {
        return manage_r();
    }
    else if (c == 's')
    {
        return manage_s();
    }
    else if (c == 't')
    {
        return manage_t();
    }
    else if (c == 'u')
    {
        return manage_u();
    }
    else if (c == 'v')
    {
        return manage_v();
    }
    else if (c == 'w')
    {
        return manage_w();
    }
    else if (c == '\n')
    {
        lines += 1;
    }
    if (c == EOF)
    {
        return -1;
    }
}

int manage_a()
{
    char c = get_char();
    if (c == 'u')
    {
        return manage_au();
    }
    return 0;
}

int manage_b()
{
    char c = get_char();
    if (c == 'r')
    {
        return manage_br();
    }
    return 0;
}

int manage_c()
{
    char c = get_char();
    if (c == 'a')
    {
        return manage_ca();
    }
    else if (c == 'h')
    {
        return manage_ch();
    }
    else if (c == 'o')
    {
        return manage_co();
    }
    return 0;
}

int manage_d()
{
    char c = get_char();
    if (c == 'e')
    {
        return manage_de();
    }
    else if (c == 'o')
    {
        return 1;
    }
    return 0;
}

int manage_e()
{
    char c = get_char();
    if (c == 'l')
    {
        return manage_el();
    }
    else if (c == 'n')
    {
        return manage_en();
    }
    else if (c == 'x')
    {
        return manage_ex();
    }
    return 0;
}

int manage_f()
{
    char c = get_char();
    if (c == 'l')
    {
        return manage_fl();
    }
    else if (c == 'o')
    {
        return manage_fo();
    }
    return 0;
}

int manage_g()
{
    char c = get_char();
    if (c == 'o')
    {
        return manage_go();
    }
    return 0;
}

int manage_i()
{
    char c = get_char();
    if (c == 'f')
    {
        return 1;
    }
    else if (c == 'n')
    {
        return manage_in();
    }
    return 0;
}

int manage_l()
{
    char c = get_char();
    if (c == 'o')
    {
        return manage_lo();
    }
    return 0;
}

int manage_r()
{
    char c = get_char();
    if (c == 'e')
    {
        return manage_re();
    }
    return 0;
}

int manage_s()
{
    char c = get_char();
    if (c == 'h')
    {
        return manage_sh();
    }
    else if (c == 'i')
    {
        return manage_si();
    }
    else if (c == 't')
    {
        return manage_st();
    }
    return 0;
}

int manage_t()
{
    char c = get_char();
    if (c == 'y')
    {
        return manage_ty();
    }
    return 0;
}

int manage_u()
{
    char c = get_char();
    if (c == 'n')
    {
        return manage_un();
    }
    return 0;
}

int manage_v()
{
    char c = get_char();
    if (c == 'o')
    {
        return manage_vo();
    }
    return 0;
}

int manage_w()
{
    char c = get_char();
    if (c == 'h')
    {
        return manage_wh();
    }
    return 0;
}

int manage_au()
{
    char c = get_char();
    if (c == 't')
    {
        return manage_aut();
    }
    return 0;
}

int manage_br()
{
    char c = get_char();
    if (c == 'e')
    {
        return manage_bre();
    }
    return 0;
}

int manage_ca()
{
    char c = get_char();
    if (c == 's')
    {
        return manage_cas();
    }
    return 0;
}

int manage_ch()
{
    char c = get_char();
    if (c == 'a')
    {
        return manage_cha();
    }
    return 0;
}

int manage_co()
{
    char c = get_char();
    if (c == 'n')
    {
        return manage_con();
    }
    return 0;
}

int manage_de()
{
    char c = get_char();
    if (c == 'f')
    {
        return manage_def();
    }
    return 0;
}

int manage_do()
{
    char c = get_char();
    if (c == '')
    {
        return 1;
    }
    else if (c == 'u')
    {
        return manage_dou();
    }
    return 0;
}

int manage_el()
{
    char c = get_char();
    if (c == 's')
    {
        return manage_els();
    }
    return 0;
}

int manage_en()
{
    char c = get_char();
    if (c == 'u')
    {
        return manage_enu();
    }
    return 0;
}

int manage_ex()
{
    char c = get_char();
    if (c == 't')
    {
        return manage_ext();
    }
    return 0;
}

int manage_fl()
{
    char c = get_char();
    if (c == 'o')
    {
        return manage_flo();
    }
    return 0;
}

int manage_fo()
{
    char c = get_char();
    if (c == 'r')
    {
        return 1;
    }
    return 0;
}

int manage_go()
{
    char c = get_char();
    if (c == 't')
    {
        return manage_got();
    }
    return 0;
}

int manage_in()
{
    char c = get_char();
    if (c == 't')
    {
        return 1;
    }
    else if (c == 'c')
    {
        return manage_inc();
    }
    return 0;
}

int manage_lo()
{
    char c = get_char();
    if (c == 'n')
    {
        return manage_lon();
    }
    return 0;
}

int manage_re()
{
    char c = get_char();
    if (c == 'g')
    {
        return manage_reg();
    }
    else if (c == 't')
    {
        return manage_ret();
    }
    return 0;
}

int manage_sh()
{
    char c = get_char();
    if (c == 'o')
    {
        return manage_sho();
    }
    return 0;
}

int manage_si()
{
    char c = get_char();
    if (c == 'g')
    {
        return manage_sig();
    }
    else if (c == 'z')
    {
        return manage_siz();
    }
    return 0;
}

int manage_st()
{
    char c = get_char();
    if (c == 'a')
    {
        return manage_sta();
    }
    else if (c == 'r')
    {
        return manage_str();
    }
    return 0;
}

int manage_ty()
{
    char c = get_char();
    if (c == 'p')
    {
        return manage_typ();
    }
    return 0;
}

int manage_un()
{
    char c = get_char();
    if (c == 'i')
    {
        return manage_uni();
    }
    else if (c == 's')
    {
        return manage_uns();
    }
    return 0;
}

int manage_vo()
{
    char c = get_char();
    if (c == 'i')
    {
        return manage_voi();
    }
    else if (c == 'l')
    {
        return manage_vol();
    }
    return 0;
}

int manage_wh()
{
    char c = get_char();
    if (c == 'i')
    {
        return manage_whi();
    }
    return 0;
}

int manage_aut()
{
    char c = get_char();
    if (c == 'o')
    {
        return 1;
    }
    return 0;
}

int manage_bre()
{
    char c = get_char();
    if (c == 'a')
    {
        return manage_brea();
    }
    return 0;
}

int manage_cas()
{
    char c = get_char();
    if (c == 'e')
    {
        return 1;
    }
    return 0;
}

int manage_cha()
{
    char c = get_char();
    if (c == 'r')
    {
        return 1;
    }
    return 0;
}

int manage_con()
{
    char c = get_char();
    if (c == 's')
    {
        return manage_cons();
    }
    else if (c == 't')
    {
        return manage_cont();
    }
    return 0;
}

int manage_def()
{
    char c = get_char();
    if (c == 'a')
    {
        return manage_defa();
    }
    return 0;
}

int manage_dou()
{
    char c = get_char();
    if (c == 'b')
    {
        return manage_doub();
    }
    return 0;
}

int manage_els()
{
    char c = get_char();
    if (c == 'e')
    {
        return 1;
    }
    return 0;
}

int manage_enu()
{
    char c = get_char();
    if (c == 'm')
    {
        return 1;
    }
    return 0;
}

int manage_ext()
{
    char c = get_char();
    if (c == 'e')
    {
        return manage_exte();
    }
    return 0;
}

int manage_flo()
{
    char c = get_char();
    if (c == 'a')
    {
        return manage_floa();
    }
    return 0;
}

int manage_got()
{
    char c = get_char();
    if (c == 'o')
    {
        return 1;
    }
    return 0;
}

int manage_lon()
{
    char c = get_char();
    if (c == 'g')
    {
        return 1;
    }
    return 0;
}

int manage_reg()
{
    char c = get_char();
    if (c == 'i')
    {
        return manage_regi();
    }
    return 0;
}

int manage_ret()
{
    char c = get_char();
    if (c == 'u')
    {
        return manage_retu();
    }
    return 0;
}

int manage_sho()
{
    char c = get_char();
    if (c == 'r')
    {
        return manage_shor();
    }
    return 0;
}

int manage_sig()
{
    char c = get_char();
    if (c == 'n')
    {
        return manage_sign();
    }
    return 0;
}

int manage_siz()
{
    char c = get_char();
    if (c == 'e')
    {
        return manage_size();
    }
    return 0;
}

int manage_sta()
{
    char c = get_char();
    if (c == 't')
    {
        return manage_stat();
    }
    return 0;
}

int manage_str()
{
    char c = get_char();
    if (c == 'u')
    {
        return manage_stru();
    }
    return 0;
}

int manage_typ()
{
    char c = get_char();
    if (c == 'e')
    {
        return manage_type();
    }
    return 0;
}

int manage_uni()
{
    char c = get_char();
    if (c == 'o')
    {
        return manage_unio();
    }
    return 0;
}

int manage_uns()
{
    char c = get_char();
    if (c == 'i')
    {
        return manage_unsi();
    }
    return 0;
}

int manage_voi()
{
    char c = get_char();
    if (c == 'd')
    {
        return 1;
    }
    return 0;
}

int manage_vol()
{
    char c = get_char();
    if (c == 'a')
    {
        return manage_vola();
    }
    return 0;
}

int manage_whi()
{
    char c = get_char();
    if (c == 'l')
    {
        return manage_whil();
    }
    return 0;
}

int manage_inc()
{
    char c = get_char();
    if (c == 'l')
    {
        return manage_incl();
    }
    return 0;
}

int manage_brea()
{
    char c = get_char();
    if (c == 'k')
    {
        return 1;
    }
    return 0;
}

int manage_cons()
{
    char c = get_char();
    if (c == 't')
    {
        return 1;
    }
    return 0;
}

int manage_cont()
{
    char c = get_char();
    if (c == 'i')
    {
        return manage_conti();
    }
    return 0;
}

int manage_defa()
{
    char c = get_char();
    if (c == 'u')
    {
        return manage_defau();
    }
    return 0;
}

int manage_doub()
{
    char c = get_char();
    if (c == 'l')
    {
        return manage_doubl();
    }
    return 0;
}

int manage_exte()
{
    char c = get_char();
    if (c == 'r')
    {
        return manage_exter();
    }
    return 0;
}

int manage_floa()
{
    char c = get_char();
    if (c == 't')
    {
        return 1;
    }
    return 0;
}

int manage_regi()
{
    char c = get_char();
    if (c == 's')
    {
        return manage_regis();
    }
    return 0;
}

int manage_retu()
{
    char c = get_char();
    if (c == 'r')
    {
        return manage_retur();
    }
    return 0;
}

int manage_shor()
{
    char c = get_char();
    if (c == 't')
    {
        return 1;
    }
    return 0;
}

int manage_sign()
{
    char c = get_char();
    if (c == 'e')
    {
        return manage_signe();
    }
    return 0;
}

int manage_size()
{
    char c = get_char();
    if (c == 'o')
    {
        return manage_sizeo();
    }
    return 0;
}

int manage_stat()
{
    char c = get_char();
    if (c == 'i')
    {
        return manage_stati();
    }
    return 0;
}

int manage_stru()
{
    char c = get_char();
    if (c == 'c')
    {
        return manage_struc();
    }
    return 0;
}

int manage_type()
{
    char c = get_char();
    if (c == 'd')
    {
        return manage_typed();
    }
    return 0;
}

int manage_unio()
{
    char c = get_char();
    if (c == 'n')
    {
        return 1;
    }
    return 0;
}

int manage_unsi()
{
    char c = get_char();
    if (c == 'g')
    {
        return manage_unsig();
    }
    return 0;
}

int manage_vola()
{
    char c = get_char();
    if (c == 't')
    {
        return manage_volat();
    }
    return 0;
}

int manage_whil()
{
    char c = get_char();
    if (c == 'e')
    {
        return 1;
    }
    return 0;
}

int manage_incl()
{
    char c = get_char();
    if (c == 'u')
    {
        return manage_inclu();
    }
    return 0;
}

int manage_conti()
{
    char c = get_char();
    if (c == 'n')
    {
        return manage_contin();
    }
    return 0;
}

int manage_defau()
{
    char c = get_char();
    if (c == 'l')
    {
        return manage_defaul();
    }
    return 0;
}

int manage_doubl()
{
    char c = get_char();
    if (c == 'e')
    {
        return 1;
    }
    return 0;
}

int manage_exter()
{
    char c = get_char();
    if (c == 'n')
    {
        return 1;
    }
    return 0;
}

int manage_regis()
{
    char c = get_char();
    if (c == 't')
    {
        return manage_regist();
    }
    return 0;
}

int manage_retur()
{
    char c = get_char();
    if (c == 'n')
    {
        return 1;
    }
    return 0;
}

int manage_signe()
{
    char c = get_char();
    if (c == 'd')
    {
        return 1;
    }
    return 0;
}

int manage_sizeo()
{
    char c = get_char();
    if (c == 'f')
    {
        return 1;
    }
    return 0;
}

int manage_stati()
{
    char c = get_char();
    if (c == 'c')
    {
        return 1;
    }
    return 0;
}

int manage_struc()
{
    char c = get_char();
    if (c == 't')
    {
        return 1;
    }
    return 0;
}

int manage_typed()
{
    char c = get_char();
    if (c == 'e')
    {
        return manage_typede();
    }
    return 0;
}

int manage_unsig()
{
    char c = get_char();
    if (c == 'n')
    {
        return manage_unsign();
    }
    return 0;
}

int manage_volat()
{
    char c = get_char();
    if (c == 'i')
    {
        return manage_volati();
    }
    return 0;
}

int manage_inclu()
{
    char c = get_char();
    if (c == 'd')
    {
        return manage_includ();
    }
    return 0;
}

int manage_contin()
{
    char c = get_char();
    if (c == 'u')
    {
        return manage_continu();
    }
    return 0;
}

int manage_defaul()
{
    char c = get_char();
    if (c == 't')
    {
        return 1;
    }
    return 0;
}

int manage_regist()
{
    char c = get_char();
    if (c == 'e')
    {
        return manage_registe();
    }
    return 0;
}

int manage_typede()
{
    char c = get_char();
    if (c == 'f')
    {
        return 1;
    }
    return 0;
}

int manage_unsign()
{
    char c = get_char();
    if (c == 'e')
    {
        return manage_unsigne();
    }
    return 0;
}

int manage_volati()
{
    char c = get_char();
    if (c == 'l')
    {
        return manage_volatil();
    }
    return 0;
}

int manage_includ()
{
    char c = get_char();
    if (c == 'e')
    {
        return 1;
    }
    return 0;
}

int manage_continu()
{
    char c = get_char();
    if (c == 'e')
    {
        return 1;
    }
    return 0;
}

int manage_registe()
{
    char c = get_char();
    if (c == 'r')
    {
        return 1;
    }
    return 0;
}

int manage_unsigne()
{
    char c = get_char();
    if (c == 'd')
    {
        return 1;
    }
    return 0;
}

int manage_volatil()
{
    char c = get_char();
    if (c == 'e')
    {
        return 1;
    }
    return 0;
}

int main(int argc, const char **argv)
{

    return 0;
}
char get_char()
{
}
