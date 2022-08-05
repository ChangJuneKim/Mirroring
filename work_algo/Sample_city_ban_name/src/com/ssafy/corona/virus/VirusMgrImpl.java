package com.ssafy.corona.virus;

public class VirusMgrImpl implements VirusMgr {
	private Virus[] virus;
	private int index;
	
	public VirusMgrImpl() {
		virus=new Virus[100];		
	}
	
	@Override
	public void add(Virus v){
		try {
			search(v.getName());
		} catch (NotFoundException e) {
			virus[index++]=v;
		}
	}
	@Override
	public Virus[] search() {
		return virus;
	}
	@Override
	public Virus search(String name) throws NotFoundException{
		for(int i=0; i<virus.length; i++) {
			if(virus[i].getName().equals(name)) return virus[i];
		}
		throw new NotFoundException(name+": 미등록 바이러스입니다.");
	}
}
