package fr.florian.mazur.utils;

import java.util.Arrays;
import java.util.List;

public enum NombreDeMasse {
	
	 H(Arrays.asList(1, 2, 3)), 
	 
	 He(Arrays.asList(3, 4)), 
	 
	 Li(Arrays.asList(6, 7)),
	 
	 Be(Arrays.asList(7, 8, 9, 10)),
	 
	 B(Arrays.asList(10, 11)),
	 
	 C(Arrays.asList(11, 12, 13, 14)),
	 
	 N(Arrays.asList(13, 14, 15, 16, 17)),
	 
	 O(Arrays.asList(15, 16, 17, 18)), 
	 
	 F(Arrays.asList(18, 19)),
	 
	 Ne(Arrays.asList(20, 22)),
	 
	 Na(Arrays.asList(22, 23, 24)),
	 
	 Mg(Arrays.asList(23, 24, 27)),
	 
	 Al(Arrays.asList(27, 29)),
	 
	 Si(Arrays.asList(27, 28, 30, 31)),
	 
	 P(Arrays.asList(30, 31, 32)),
	 
	 S(Arrays.asList(32, 35, 36)),
	 
	 Cl(Arrays.asList(35, 36, 37, 38)),
	 
	 Ar(Arrays.asList(37, 40, 41)),
	 
	 K(Arrays.asList(39, 40, 42)),
	 
	 Ca(Arrays.asList(40, 41, 45, 49)),
	 
	 Sc(Arrays.asList(45, 46, 48)),
	 
	 Ti(Arrays.asList(48, 51)),
	 
	 V(Arrays.asList(48, 49, 51)),
	 
	 Cr(Arrays.asList(51, 52)),
	 
	 Mn(Arrays.asList(52, 54, 55)),
	 
	 Fe(Arrays.asList(55, 56, 59)),
	 
	 Co(Arrays.asList(56, 59, 60)),
	 
	 Ni(Arrays.asList(58, 59, 60, 64)),
	 
	 Cu(Arrays.asList(61, 63, 64, 65)),
	 
	 Zn(Arrays.asList(64, 65, 66, 69)),
	 
	 Ga(Arrays.asList(66, 69, 72)),
	 
	 Ge(Arrays.asList(71, 72, 73, 74)),
	 
	 As(Arrays.asList(74, 75, 76, 77)),
	 
	 Se(Arrays.asList(75, 77, 80, 87)),
	 
	 Br(Arrays.asList(79, 81, 82, 86, 87)),
	 
	 Kr(Arrays.asList(83, 84, 85, 89, 92)),
	 
	 Rb(Arrays.asList(85, 86, 87)),
	 
	 Sr(Arrays.asList(86, 87, 88, 89, 90)),
	 
	 Y(Arrays.asList(89, 90)),
	 
	 Zr(Arrays.asList(90, 95)),
	 
	 Nb(Arrays.asList(93)),
	 
	 Mo(Arrays.asList(98, 99)),
	 
	 Tc(Arrays.asList(97, 98, 99)),
	 
	 Ru(Arrays.asList(97, 102, 103)),
	 
	 Rh(Arrays.asList(103, 105)),
	 
	 Pd(Arrays.asList(103, 105, 106)),
	 
	 Ag(Arrays.asList(107, 108, 109, 110, 111)),
	 
	 Cd(Arrays.asList(106, 111, 113, 114, 115)),
	 
	 In(Arrays.asList(113, 114, 115)),
	 
	 Sn(Arrays.asList(113, 117, 119, 120)),
	 
	 Sb(Arrays.asList(121, 122, 124, 125)),
	 
	 Te(Arrays.asList(123, 125, 127, 129, 130, 131)),
	 
	 I(Arrays.asList(127, 131)),
	 
	 Xe(Arrays.asList(129, 131, 132, 136, 140)),
	 
	 Cs(Arrays.asList(133, 137, 134, 140)),
	 
	 Ba(Arrays.asList(137, 138, 140, 141, 144)),
	 
	 La(Arrays.asList(138, 139, 140)),
	 
	 Ce(Arrays.asList(140, 141)),
	 
	 Pr(Arrays.asList(141, 142, 143)),
	 
	 Nd(Arrays.asList(142, 143, 144,147)),
	 
	 Pm(Arrays.asList(145, 147)),
	 
	 Sm(Arrays.asList(147, 152, 153)),
	 
	 Eu(Arrays.asList(153, 154, 155)),
	 
	 Gd(Arrays.asList(158)),
	 
	 Tb(Arrays.asList(159)),
	 
	 Dy(Arrays.asList(164)),
	 
	 Ho(Arrays.asList(165)),
	 
	 Er(Arrays.asList(166)),
	 
	 Tm(Arrays.asList(169)),
	 
	 Yb(Arrays.asList(174)),
	 
	 Lu(Arrays.asList(175, 176)),
	 
	 Hf(Arrays.asList(179, 180, 181)),
	 
	 Ta(Arrays.asList(180, 181, 182)),
	 
	 W(Arrays.asList(180, 183, 184, 185, 187)),
	 
	 Re(Arrays.asList(186, 187, 188)),
	 
	 Os(Arrays.asList(185, 187, 190, 191, 192, 193)),
	 
	 Ir(Arrays.asList(191, 192, 193, 194)),
	 
	 Pt(Arrays.asList(190, 195, 197)),
	 
	 Au(Arrays.asList(197, 198, 199)),
	 
	 Hg(Arrays.asList(197, 199, 202, 203)),
	 
	 Tl(Arrays.asList(205, 206, 207, 208, 210)),
	 
	 Pb(Arrays.asList(204, 206, 207, 208, 209, 210, 212, 214)),
	 
	 Bi(Arrays.asList(209, 210, 211, 212, 213, 214, 215)),
	 
	 Po(Arrays.asList(210, 211, 212, 213, 214, 215, 216, 218)),
	 
	 At(Arrays.asList(210, 211, 217, 218)),
	 
	 Rn(Arrays.asList(219, 220, 222)),
	 
	 Fr(Arrays.asList(221, 223)),
	 
	 
	 ;

	 private final List<Integer> a;

	 private NombreDeMasse(List<Integer> a) {
	   this.a = a;
	 }

	 public List<Integer> getValeur() {
	   return this.a;
	 }

}
