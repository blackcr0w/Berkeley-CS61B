public abstract class AbstractXList implements XList {
	@Override
	public int getBack(){
		return get(size());
	}
}