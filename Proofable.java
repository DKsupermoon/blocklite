
public interface Proofable {
	public String generateProof(Block block);
	public boolean verifyProof(Block block);
}
